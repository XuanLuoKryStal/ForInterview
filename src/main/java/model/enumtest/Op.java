package model.enumtest;

public enum  Op {
    LE {
        @Override
        void toSql() {
            System.out.println("<=");
        }
    },

    GE{
        @Override
        void toSql() {
            System.out.println(">=");
        }
    };

    abstract  void toSql();
}
