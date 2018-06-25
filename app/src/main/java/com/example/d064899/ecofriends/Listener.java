package com.example.d064899.ecofriends;

import com.google.firebase.database.DataSnapshot;

public interface Listener {
    void onSuccess(DataSnapshot data, String id);
}
