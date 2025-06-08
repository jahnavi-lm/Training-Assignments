package JavaAssignment_June07.LibraryManagement.service;

import JavaAssignment_June07.LibraryManagement.exception.BookNotAvailableException;
import JavaAssignment_June07.LibraryManagement.exception.BookNotFoundException;
import JavaAssignment_June07.LibraryManagement.exception.MemberNotFoundException;
import JavaAssignment_June07.LibraryManagement.exception.OverdueBookException;
import JavaAssignment_June07.LibraryManagement.model.*;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class LibraryService {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    private List<LendingRecord> lendingRecords = new ArrayList<>();

    // Add book
    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    // Remove book
    public void removeBook(String bookId) throws BookNotFoundException {
        if (!books.containsKey(bookId)) {
            throw new BookNotFoundException("Book ID " + bookId + " not found.");
        }
        books.remove(bookId);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    // Get all members
    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    // Add member
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    // Get member by ID
    public Member getMemberById(String memberId) {
        return members.get(memberId);
    }

    // Issue book to member
    public void issueBook(String bookId, String memberId) throws BookNotFoundException, BookNotAvailableException, MemberNotFoundException, OverdueBookException {
        Book book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book ID " + bookId + " not found.");
        }
        if (book.isIssued()) {
            throw new BookNotAvailableException("Book '" + book.getTitle() + "' is already issued.");
        }
        Member member = members.get(memberId);
        if (member == null) {
            throw new MemberNotFoundException("Member ID " + memberId + " not found.");
        }
        // Check if member has overdue books
        boolean hasOverdue = lendingRecords.stream()
                .anyMatch(r -> r.getMember().equals(member)
                        && r.getReturnDate() == null
                        && r.getDueDate().isBefore(LocalDate.now()));
        if (hasOverdue) {
            throw new OverdueBookException("Member has overdue books. Cannot issue new books.");
        }

        // Issue book
        book.setIssued(true);
        LendingRecord record = new LendingRecord(
                UUID.randomUUID().toString(),
                book,
                member,
                LocalDate.now(),
                LocalDate.now().plusWeeks(2),
                null
        );
        lendingRecords.add(record);
    }

    // Return book
    public void returnBook(String bookId, String memberId) throws BookNotFoundException, MemberNotFoundException {
        Book book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book ID " + bookId + " not found.");
        }
        Member member = members.get(memberId);
        if (member == null) {
            throw new MemberNotFoundException("Member ID " + memberId + " not found.");
        }

        Optional<LendingRecord> recordOpt = lendingRecords.stream()
                .filter(r -> r.getBook().equals(book)
                        && r.getMember().equals(member)
                        && r.getReturnDate() == null)
                .findFirst();

        if (recordOpt.isEmpty()) {
            System.out.println("No active lending record found for this book and member.");
            return;
        }

        LendingRecord record = recordOpt.get();
        record.setReturnDate(LocalDate.now());
        book.setIssued(false);
    }

    public List<Book> getAvailableBooks() {
        return books.values().stream()
                .filter(book -> !book.isIssued())
                .collect(Collectors.toList());
    }

    public List<LendingRecord> getOverdueRecords() {
        LocalDate today = LocalDate.now();
        return lendingRecords.stream()
                .filter(record -> record.getReturnDate() == null && record.getDueDate().isBefore(today))
                .collect(Collectors.toList());
    }
}
