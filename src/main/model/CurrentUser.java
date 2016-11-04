package main.model;
/*by Mykhailo Kosynskyi
 In this class we will be stored and get our current user from keyboard
 MS: maybe it should extend User?
 */
public class CurrentUser {
    public static User currentUser;

    public CurrentUser() {
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        CurrentUser.currentUser = currentUser;
    }
}
