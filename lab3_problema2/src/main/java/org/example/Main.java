package org.example;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String python_code = "import re\n" +
                "def functie():\n" +
                "    with open(\"fisier.in\" , \"r\") as file:\n" +
                "        text = file.read()\n" +
                "    text = re.sub(r' +', \" \", text) \n" +
                "    text = re.sub(r'\\n+' , \"\\n\" , text)\n" +
                "    text = re.sub(r'\\n\\s*\\d+\\s*\\n' , '\\n',text)\n" +
                "    return text\n" +
                "\n";

        try (Context polyglot = Context.newBuilder().allowAllAccess(true).build()) {
            polyglot.eval("python" , python_code);
            Value functie = polyglot.getBindings("python").getMember("functie");
            Value rezultat = functie.execute();
            System.out.println(rezultat.asString());
        }
    }
}