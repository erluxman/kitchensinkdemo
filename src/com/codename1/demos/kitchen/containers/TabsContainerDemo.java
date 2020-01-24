package com.codename1.demos.kitchen.containers;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Tabs;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;


public class TabsContainerDemo {
    public static Button getInstance() {
        Button show = new Button("Show Tabs Page");
        Form form = new Form("Tabs Page", new BorderLayout());

        SpanLabel number0 = new SpanLabel("0 (zero) is a number,[1] and the numerical digit used to represent " +
                "that number in numerals. It fulfills a central role in mathematics as the additive identity of the " +
                "integers, real numbers, and many other algebraic structures. As a digit, 0 is used as a placeholder " +
                "in place value systems. Names for the number 0 in English include zero, nought (UK), naught (US) " +
                "(/nɔːt/), nil, or—in contexts where at least one adjacent digit distinguishes it from the letter " +
                "\"O\"—oh or o (/oʊ/). Informal or slang terms for zero include zilch and zip.[2] Ought and aught " +
                "(/ɔːt/),[3] as well as cipher,[4] have also been used historically.[5]");
        SpanLabel number1 = new SpanLabel("1 (one, also called unit, and unity) is a number, and a numerical " +
                "digit used to represent that number in numerals. It represents a single entity, the unit " +
                "of counting or measurement. For example, a line segment of unit length is a line segment " +
                "of length 1. 1 is the smallest positive integer. It is also sometimes considered the " +
                "first of the infinite sequence of natural numbers, followed by 2, although by other " +
                "definitions 1 is the second natural number, following 0. The fundamental mathematical property" +
                " of 1 is to be a multiplicative identity, meaning that any number multiplied by 1 returns " +
                "that number. Most if not all properties of 1 can be deduced from this. In advanced mathematics," +
                " a multiplicative identity is often denoted 1, even if it is not a number. 1 is by convention " +
                "not considered a prime number; although universal today, this was a matter of some controversy" +
                " until the mid-20th century.");

        SpanLabel number2 = new SpanLabel("In mathematics\n" +
                "256 is a composite number, with the factorization 256 = 28, which makes it a power of two.\n" +
                "256 is 4 raised to the 4th power, so in tetration notation 256 is 24.[1] 256 is a perfect square " +
                "(162). 256 is the only 3-digit number that is zenzizenzizenzic. It is 2 to the 8th power or " +
                " displaystyle ((2^{2})^{2})^{2}}((2^{2})^{2})^{2}. 256 is the lowest number that is a product of " +
                "eight prime factors.\n\n " +
                "In computing One octet (in most cases one byte) is equal to eight bits and has 28 or " +
                "256 possible values, counting from 0 to 255. The number 256 often appears in computer " +
                "applications (especially on 8-bit systems) such as:\n" +
                "The typical number of different values in each color channel of a digital color image " +
                "(256 values for red, 256 values for green, and 256 values for blue used for 24-bit color) " +
                "(see color space or Web colors).\n" +
                "The number of colors available in a GIF or a 256-color (8-bit) bitmap.\n" +
                "The number of characters in extended ASCII[2] and Latin-1.[3]\n" +
                "The number of columns available in a Microsoft Excel worksheet until Excel 2007.[4]\n" +
                "The split-screen level in Pac-Man, which results from the use of a single byte to store the internal " +
                "level counter.A 256-bit integer can represent up to 1.1579209e+77 values.[5] Number of bits in the " +
                "SHA-256 cryptographic hash. The branding number of nVidia's GeForce 256");
        Tabs tabs = new Tabs();
        tabs.addTab("Number 0", new Container(BoxLayout.yCenter()).add(number0));
        tabs.addTab("Number 1", new Container(BoxLayout.yCenter()).add(number1));
        tabs.addTab("Number 256", new Container(BoxLayout.yCenter()).add(number2));
        tabs.setAnimateTabSelection(true);
        form.add(BorderLayout.CENTER, tabs);
        form.getToolbar().setBackCommand("Line Chart", ee -> show.getComponentForm().showBack());
        show.addActionListener(evt -> {
            form.show();
        });
        return show;
    }
}
