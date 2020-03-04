class Database {
    private int readers; // number of active readers

    public Database() {
        this.readers = 0;
    }

    public void read(int number) {
        synchronized (this) {
            this.readers++;
            System.out.println("Reader " + number + " starts reading.");
        }

        final int DELAY = 5000;
        try {
            Thread.sleep((int) (Math.random() * DELAY));
        } catch (InterruptedException e) {
        }

        synchronized (this) {
            System.out.println("Reader " + number + " stops reading.");
            this.readers--;
            if (this.readers == 0) {
                this.notifyAll();
            }
        }
    }

    public synchronized void write(int number) {
        while (this.readers != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Writer " + number + " starts writing.");

        final int DELAY = 5000;
        try {
            Thread.sleep((int) (Math.random() * DELAY));
        } catch (InterruptedException e) {
        }

        System.out.println("Writer " + number + " stops writing.");
        this.notifyAll();
    }
}

class Reader extends Thread {
    private static int readers = 0; // number of readers

    private int number;
    private Database database;

    public Reader(Database database) {
        this.database = database;
        this.number = Reader.readers++;
    }

    public void run() {
        while (true) {
            final int DELAY = 5000;
            try {
                Thread.sleep((int) (Math.random() * DELAY));
            } catch (InterruptedException e) {
            }
            this.database.read(this.number);
        }
    }
}

class Writer extends Thread {
    private static int writers = 0; // number of writers

    private int number;
    private Database database;

    public Writer(Database database) {
        this.database = database;
        this.number = Writer.writers++;
    }

    public void run() {
        while (true) {
            final int DELAY = 5000;
            try {
                Thread.sleep((int) (Math.random() * DELAY));
            } catch (InterruptedException e) {
            }
            this.database.write(this.number);
        }
    }
}

class Simulator {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Simulator <number of readers> <number of writers>");
        } else {
            final int READERS = Integer.parseInt(args[0]);
            final int WRITERS = Integer.parseInt(args[1]);
            Database database = new Database();
            for (int i = 0; i < READERS; i++) {
                new Reader(database).start();
            }
            for (int i = 0; i < WRITERS; i++) {
                new Writer(database).start();
            }
        }
    }
}