package cucumber.datatables.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class MyStepdefs {
    @Given("given condition")
    public void givenCondition() {
        System.out.println("given condition");
    }

    @When("user use following list as column data")
    public void userUseFollowingListAsColumnData(DataTable table) {
        List<Integer> list = table.asList(Integer.class);
        System.out.println(list);
    }

    @When("user use following list as row data")
    public void userUseFollowingData(DataTable table) {
        // Integer.class nedeni ile datalari Integer olarak alacak
        List<List<Integer>> list = table.asLists(Integer.class);
        System.out.println(list);
    }


    @When("user use following list of list data")
    public void userUseFollowingListOfListData(DataTable table) {
        // datalari String olarak alacak, ya String.class yazilir ya bos birakilir
        List<List<String>> lists = table.asLists(String.class);

        for (List<String> list : lists) {

            for(String s : list){
                System.out.printf("%s\t", s);
            }
            System.out.println();
        }
    }

    @When("user use following map data")
    public void userUseFollowingMapData(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        System.out.println(map);

    }

    @When("user use following list of maps data")
    public void userUseFollowingListOfMapsData(DataTable table) {
        List<Map<String, Integer>> maps = table.asMaps(String.class, Integer.class);
        for (Map<String, Integer> map : maps) {
            System.out.println(map);
        }
    }


    @Then("then condition")
    public void thenCondition() {
        System.out.println("Then condition");
    }
}
