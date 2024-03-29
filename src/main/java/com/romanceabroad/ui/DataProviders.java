package com.romanceabroad.ui;

import org.testng.annotations.DataProvider;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataProviders {

    @DataProvider(name = "PrettyWomen")
    public static Object[][] testSearchFeature() {
        return new Object[][]{
                {"18", "80", "Default"},
                {"18", "19", "Name"},
                {"30", "40", "Views"},
                {"60", "80", "Registration date"}
        };

    }

    @DataProvider(name = "Registration2")
    public static Object[][] testRegistration2() {
        return new Object[][]{
                {Data.email1, Data.username, true}
                //{Data.email2, Data.username, false},
                //{Data.email3, Data.username, true}
        };

    }

    @DataProvider(name = "Registration")
    public static Object[][] testRegistration1() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("Registration.csv")).stream().forEach(s -> {

            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
        });

        return out.toArray(new Object[out.size()][]);
    }

    @DataProvider(name = "SignIn")
    public static Object[][] testSignInNeg() throws Exception {
        return new Object[][]{
                {"uhduwuw@.com", "vfsdssveegf", false},
                {"manthesky@gmail.com","ooaxoamaooom450941!", true}
        };
    }

    @DataProvider(name = "NewRequirementsForPassword")
    public static Object[][] newRequirementsForPasswords() {
        return new Object[][] {
                {"Boston1!", true},
                {"Boston2@", true},
                {"#Boston3", true},
                {"$Boston4", true},
                {"Bos%ton5", true},
                {"B^os6ton", true},
                {"7Bosto&n", true},
                {"Mia12**mi", true},
                {"Miami*-(13)", true},
                {"Miami*-14", true},
                {"Mi+am19i", true},
                {"Utah", false},
                {"***", false},
                {"56986545", false},
                {"worthless", false},
                {"Mean450941)", false},
                {"worthle98ss", false},
                {"porlock09", false},
                {"lowerc:9", false},
                {"DUSSELDORF1!", false}

        };
    }
}
