package com.planetapps.online_quiz

import com.google.firebase.firestore.FirebaseFirestore

object FirestoreHelper {

    private val db = FirebaseFirestore.getInstance()
    private val playersCollection = db.collection("players")

    fun addPlayer(player: Player, callback: (Boolean) -> Unit) {
        playersCollection.add(player)
            .addOnSuccessListener { documentReference ->
                callback(true)
            }
            .addOnFailureListener { e ->
                callback(false)
            }
    }


}
