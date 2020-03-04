import java.util.Random;

class Thread1 extends Thread {
    int[] voteSubArray = new int[60];
    int[] voteCountSub = { 0, 0, 0 };

    public Thread1(int[] totalVotes, int start, int end) {
        super();
        for (int i = start; i < end; i++) {
            voteSubArray[i - start] = totalVotes[i];
        }

    }

    void countVote() {
        for (int i : voteSubArray) {
            if (i == 1) {
                voteCountSub[0] = voteCountSub[0] + 1;
            } else if (i == 2) {
                voteCountSub[1] = voteCountSub[1] + 1;
            } else if (i == 3) {

                voteCountSub[2] = voteCountSub[2] + 1;
            }
        }

    }

    public void run() {
        countVote();

    }
}

class Lab5_1 {

    public static void main(String[] args) {
        int[] totalVotes = new int[240];
        int[] results = { 0, 0, 0 };
        Random rand = new Random();
        for (int i = 0; i < 240; i++) {
            totalVotes[i] = 1 + rand.nextInt(3);
        }
        System.out.println("Votes Recieved:");

        for (int i : totalVotes) {
            System.out.print(i + " ");
        }
        System.out.println();

        Thread1 t1 = new Thread1(totalVotes, 0, 60);
        Thread1 t2 = new Thread1(totalVotes, 60, 120);
        Thread1 t3 = new Thread1(totalVotes, 120, 180);
        Thread1 t4 = new Thread1(totalVotes, 180, 240);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        } catch (InterruptedException e) {
            System.out.println(e);

        }
        for (int i = 0; i < 3; i++) {
            results[0] = t1.voteCountSub[0] + t2.voteCountSub[0] + t3.voteCountSub[0] + t4.voteCountSub[0];
            results[1] = t1.voteCountSub[1] + t2.voteCountSub[1] + t3.voteCountSub[1] + t4.voteCountSub[1];
            results[2] = t1.voteCountSub[2] + t2.voteCountSub[2] + t3.voteCountSub[2] + t4.voteCountSub[2];

        }
        System.out.println("Results");
        for (int i : results) {
            System.out.print(i + " ");
        }
        System.out.println();
        if (results[0] >= results[1] && results[0] >= results[2]) {
            System.out.println("The PR is A");
        } else if (results[1] >= results[0] && results[1] >= results[2]) {
            System.out.println("The PR is B");
        } else {
            System.out.println("The PR is C");
        }
    }
}