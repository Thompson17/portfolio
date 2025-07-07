package com.company;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
	Cardinal c = new Cardinal(2);
	Cardinal d = new Cardinal(1);
	Cardinal e = new Cardinal(c);
	c.sub(d);
	e.wert = Cardinal.sub(c, d);
	System.out.println(c.toString());
	System.out.println(e.toString());
    }
}
