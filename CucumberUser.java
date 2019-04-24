package se.iths.selenium.assignement4;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import se.iths.cucumber.CucumberHooks;
import se.iths.selenium.assignmentrestAPI.User;
import se.iths.selenium.assignmentrestAPI.UserJacksonTest;
import se.iths.selenium.assignmentrestAPI.UserPetStoreClient;

public class CucumberUser {

    @Given("create a user with id {int}")
    public void create_a_user_with_id(Integer userId) {

        User qasim = new User(userId, "qasim", "Qasim", "khan",
                "qasim_ajk@yahoo.com", "kashmir");

        CucumberHooks.getWorld().setQasim(qasim);

        new UserPetStoreClient().createUser(qasim);
    }

    @Then("i login the user with correct user name {string} and password {string}")
    public void i_login_the_user_with_correct_user_name_and_password(String username, String password) {

        Boolean userLogin = new UserPetStoreClient().logIn(username, password);

        Assert.assertEquals(true, userLogin);
    }

    @Then("i login the user with wrong user name {string} and password {string}")
    public void i_login_the_user_with_wrong_user_name_and_password(String username, String password) {

        Boolean userLogin = new UserPetStoreClient().logIn1(username,password);

        Assert.assertEquals(false, userLogin);

    }

    @When("i delete the user with username {string}")
    public void i_delete_the_user_with_username(String username) {

        new UserPetStoreClient().deleteUser(username);
    }

    @Then("i get en error fetching the user with username {string}")
    public void i_get_en_error_fetching_the_user_with_username(String username) {
         User user = new UserPetStoreClient().getUser(username, 404);


    }

    @When("update the email of user with username {string}")
    public void update_the_email_of_user_with_username(String username) {
       User qasim = CucumberHooks.getWorld().getQasim();
       qasim.setEmail("xyz");
               new UserPetStoreClient().updateUserEmail(username, qasim );

    }

    @Then("validate the username {string} if changes has been made")
    public void validate_the_username_if_changes_has_been_made(String username) {
        new UserPetStoreClient().getUser(username, 200);
    }


    }



