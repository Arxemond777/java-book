package ch5;

    enum Weekdays {
        Sunday(8), Monday(0), Tuesday(1), Wednesday(2), Thursday(4),
        Friday(5), Saturday(10);
        int fun;
        Weekdays (int fun) {
            this.fun = fun;
        }
        public int getFun() {
            return fun;
        }
    };

    enum Cat {
        X, Y, Z {
            public void doSomething(){}
        }
    }
