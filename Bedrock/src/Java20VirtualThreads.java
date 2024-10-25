import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Java20VirtualThreads {

    public static void myRunnable() {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Hello World from Thread # %d%n", Thread.currentThread().threadId());
    }

    public static void main(String[] args) throws InterruptedException {

        /*
        Low level thread API
         */
        // Actual thread
/*        var thread = new Thread(() -> myRunnable());
        thread.start();
        thread.join();*/

        // Virtual threads - a lightweight thread managed by JVM, cheaper & super fast &more flexible (can have a thread pool)


        //--------------------------------------------------------------------------------------------------------------
        /*
        Executors APIs
         */

        // Actual thread
        // The max number of thread that this Executor has is 5. We can use up to 5 threads at a time;
        // The 5 threads will be re-used.
/*        long startTime = System.currentTimeMillis();

        var executor = Executors.newFixedThreadPool(5); // These are 5 'actual' threads will be run simultaneously, which are scheduled by the OS, very expensive.
        int threadCount = 20;
        IntStream.range(0, threadCount) // We are launching 10 threads in total
                .forEach(i -> executor.submit(() -> myRunnable()));
        executor.close();

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.printf("\n[Launch %d Actual Threads]: Total execution time: %d seconds%n\n", threadCount, estimatedTime);*/

        int threadCount = 10000;

        // Virtual threads
        // Performance measurements: Super fast!!! As all threadCount (e.g. 100) can be sent all together at the same time!
        // 10 threads   : 1022 secs
        // 50 threads   : 1041 secs
        // 100 threads  : 1040 secs
        // 500 threads  : 1052 secs
        // 1000 threads : 1074 secs
        // 5000 threads : 1151 secs
        // 10000 threads: 1197 secs
        long vtStartTime = System.currentTimeMillis();
        var vtExecutor = Executors.newVirtualThreadPerTaskExecutor();
        IntStream.range(0, threadCount) // We are launching 10 threads in total
                .forEach(i -> vtExecutor.submit(() -> myRunnable()));
        vtExecutor.close();

        long vtEstimatedTime = System.currentTimeMillis() - vtStartTime;
        System.out.printf("\n[Launch %d Virtual Threads]: Total execution time: %d seconds%n\n", threadCount, vtEstimatedTime);

    }
}
