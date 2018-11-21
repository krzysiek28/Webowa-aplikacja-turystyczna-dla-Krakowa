package client.utils;

import client.user.UserModel;

public class ClientStore {

    private ClientStore(){}

    public static UserModel currentUser;

    public static void setCurrentUser(UserModel currentUser) {
        ClientStore.currentUser = currentUser;
    }

    public static UserModel getCurrentUser() {
        return currentUser;
    }
}
