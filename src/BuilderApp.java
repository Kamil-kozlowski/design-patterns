public class BuilderApp {
    public static void main(String[] args) {
        final TenStringsKeeperBuilder builder = new TenStringsKeeperBuilder()
                .withString1("String1")
                .withString2("String2");

        builder
                .withString3("String3")
                .withString4("String4")
                .withString10("String10");

        builder.withString1("String1 - NEW");

        final TenStringsKeeper builtKeeper = builder.build();
        System.out.println(builtKeeper.toString());
    }
}

// Model
class TenStringsKeeper {
    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;
    private String string6;
    private String string7;
    private String string8;
    private String string9;
    private String string10;

    @Override
    public String toString() {
        return "TenStringsKeeper{" +
                "string1='" + string1 + '\'' +
                ", string2='" + string2 + '\'' +
                ", string3='" + string3 + '\'' +
                ", string4='" + string4 + '\'' +
                ", string5='" + string5 + '\'' +
                ", string6='" + string6 + '\'' +
                ", string7='" + string7 + '\'' +
                ", string8='" + string8 + '\'' +
                ", string9='" + string9 + '\'' +
                ", string10='" + string10 + '\'' +
                '}';
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }

    public void setString4(String string4) {
        this.string4 = string4;
    }

    public void setString5(String string5) {
        this.string5 = string5;
    }

    public void setString6(String string6) {
        this.string6 = string6;
    }

    public void setString7(String string7) {
        this.string7 = string7;
    }

    public void setString8(String string8) {
        this.string8 = string8;
    }

    public void setString9(String string9) {
        this.string9 = string9;
    }

    public void setString10(String string10) {
        this.string10 = string10;
    }
}

//Builder
class TenStringsKeeperBuilder {
    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;
    private String string6;
    private String string7;
    private String string8;
    private String string9;
    private String string10;

    TenStringsKeeperBuilder withString1(String string) {
        this.string1 = string;
        return this;
    }

    TenStringsKeeperBuilder withString2(String string) {
        this.string2 = string;
        return this;
    }

    TenStringsKeeperBuilder withString3(String string) {
        this.string3 = string;
        return this;
    }

    TenStringsKeeperBuilder withString4(String string) {
        this.string4 = string;
        return this;
    }

    TenStringsKeeperBuilder withString5(String string) {
        this.string5 = string;
        return this;
    }

    TenStringsKeeperBuilder withString6(String string) {
        this.string6 = string;
        return this;
    }

    TenStringsKeeperBuilder withString7(String string) {
        this.string7 = string;
        return this;
    }

    TenStringsKeeperBuilder withString8(String string) {
        this.string8 = string;
        return this;
    }

    TenStringsKeeperBuilder withString9(String string) {
        this.string9 = string;
        return this;
    }

    TenStringsKeeperBuilder withString10(String string) {
        this.string10 = string;
        return this;
    }

    TenStringsKeeper build() {
        TenStringsKeeper keeper = new TenStringsKeeper();
        keeper.setString1(string1);
        keeper.setString2(string2);
        keeper.setString3(string3);
        keeper.setString4(string4);
        keeper.setString5(string5);
        keeper.setString6(string6);
        keeper.setString7(string7);
        keeper.setString8(string8);
        keeper.setString9(string9);
        keeper.setString10(string10);
        return keeper;
    }
}


