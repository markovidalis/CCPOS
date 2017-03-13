
import javax.print.DocPrintJob;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
class PrintJobWatcher {
    boolean done = false;

  PrintJobWatcher(DocPrintJob job) {
    job.addPrintJobListener(new PrintJobAdapter() {
      public void printJobCanceled(PrintJobEvent pje) {
        synchronized (PrintJobWatcher.this) {
          done = true;
          PrintJobWatcher.this.notify();
        }
      }

      public void printJobCompleted(PrintJobEvent pje) {
        synchronized (PrintJobWatcher.this) {
          done = true;
          PrintJobWatcher.this.notify();
        }
      }

      public void printJobFailed(PrintJobEvent pje) {
        synchronized (PrintJobWatcher.this) {
          done = true;
          PrintJobWatcher.this.notify();
        }
      }

      public void printJobNoMoreEvents(PrintJobEvent pje) {
        synchronized (PrintJobWatcher.this) {
          done = true;
          PrintJobWatcher.this.notify();
        }
      }
    });
  }

  public synchronized void waitForDone() {
    try {
      while (!done) {
        wait();
      }
    } catch (InterruptedException e) {
    }
  }
}
