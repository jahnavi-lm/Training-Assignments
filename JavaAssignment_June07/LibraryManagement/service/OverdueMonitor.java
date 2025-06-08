package JavaAssignment_June07.LibraryManagement.service;
import JavaAssignment_June07.LibraryManagement.model.LendingRecord;

public class OverdueMonitor extends Thread {
    private LibraryService libraryService;

    public OverdueMonitor(LibraryService service) {
        this.libraryService = service;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(60000); // every 1 minute
                for (LendingRecord record : libraryService.getOverdueRecords()) {
                    System.out.println("[Overdue Alert] " + record);
                }
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted");
            }
        }
    }
}

