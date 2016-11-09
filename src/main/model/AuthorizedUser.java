package main.model;

/*by Mykhailo Kosynskyi
 In this class we will be stored and get our current user from keyboard
 */
public class AuthorizedUser {
    private static User authorizedUser;

    public AuthorizedUser() {
    }

    public static User getAuthorizedUser() {
        return authorizedUser;
    }

    public static void setAuthorizedUser(User user) {
        AuthorizedUser.authorizedUser = user;
    }
}
