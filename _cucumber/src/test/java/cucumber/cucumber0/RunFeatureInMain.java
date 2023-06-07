package cucumber.cucumber0;

import static io.cucumber.core.cli.Main.run;

public class RunFeatureInMain {

    public static void main(String[] args) {

        //String [] argv = new String[]{ "-g","","src/test/java/runwithjava/cucumber"};

        String [] argv = new String[]{ "-g","","src/test/java/runwithjava/cucumber/feature1.feature"};
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        byte exitstatus = run(argv, contextClassLoader);
        System.out.println(exitstatus);
    }

}
