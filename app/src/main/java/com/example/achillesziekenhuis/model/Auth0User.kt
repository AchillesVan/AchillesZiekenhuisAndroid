package com.example.achillesziekenhuis.model

import android.util.Log
import com.auth0.android.jwt.JWT

/**
 * Data class that represents an Auth0 user.
 */
data class Auth0User(
    /**
     * The JWT that represents the user.
     */
    val idToken: String? = null) {

    private val TAG = "User"

    /**
     * The user's ID.
     */
    var id = ""
    /**
     * The user's name.
     */
    var name = ""
    /**
     * The user's email address.
     */
    var email = ""
    /**
     * Whether the user's email address has been verified.
     */
    var emailVerified = ""
    /**
     * The URL of the user's profile picture.
     */
    var picture = ""
    /**
     * The time the user's profile was last updated.
     */
    var updatedAt = ""

    init {
        if (idToken != null) {
            try {
                // Attempt to decode the ID token.
                val jwt = JWT(idToken)

                // The ID token is a valid JWT,
                // so extract information about the user from it.
                id = jwt.subject ?: ""
                name = jwt.getClaim("name").asString() ?: ""
                email = jwt.getClaim("email").asString() ?: ""
                emailVerified = jwt.getClaim("email_verified").asString() ?: ""
                picture = jwt.getClaim("picture").asString() ?: ""
                updatedAt = jwt.getClaim("updated_at").asString() ?: ""
            } catch (error: com.auth0.android.jwt.DecodeException) {
                // The ID token is NOT a valid JWT, so log the error
                // and leave the user properties as empty strings.
                Log.e(TAG, "Error occurred trying to decode JWT: $error ")
            }
        } else {
            // The User object was instantiated with a null value,
            // which means the user is being logged out.
            // The user properties will be set to empty strings.
            Log.d(TAG, "User is logged out - instantiating empty User object.")
        }
    }

    override fun toString(): String {
        return "Id: ${id}\nName: ${name}\nEmail: ${email}\nVerified: ${emailVerified}\nPicture: ${picture}\nUpdated at: $updatedAt"
    }
}
