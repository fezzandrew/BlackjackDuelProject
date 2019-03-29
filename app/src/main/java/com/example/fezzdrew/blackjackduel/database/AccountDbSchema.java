package com.example.fezzdrew.blackjackduel.database;

public class AccountDbSchema {

    public static final class AccountTable {
        public static final String NAME = "accounts";

        public static final class Cols {
            public static final String ACCID = "accid";
            public static final String ACCOUNT = "account";
            public static final String BALANCE = "balance";
        }
    }
}
