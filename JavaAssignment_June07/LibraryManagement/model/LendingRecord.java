package JavaAssignment_June07.LibraryManagement.model;
import java.time.LocalDate;

public class LendingRecord {
    private String recordId;
    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public LendingRecord(String recordId, Book book, Member member, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        this.recordId = recordId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public boolean isOverdue() {
        return returnDate == null && dueDate.isBefore(LocalDate.now());
    }

    public String getRecordId() {
        return recordId;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getReturnDate() {
        return this.returnDate;
    }

    @Override
    public String toString() {
        return "Record: " + recordId + " | Book: " + book.getTitle() +
                " | Member: " + member.getName() +
                " | Due: " + dueDate +
                " | Returned: " + (returnDate == null ? "No" : returnDate);
    }
}
