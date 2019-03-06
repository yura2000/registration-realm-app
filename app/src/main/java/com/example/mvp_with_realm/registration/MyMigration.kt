package com.example.mvp_with_realm.registration

import io.realm.DynamicRealm
import io.realm.RealmMigration
import io.realm.RealmSchema



class MyMigration: RealmMigration {

    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        val schema = realm.schema

        schema.create("Answer")
            .addField("id", Long::class.java)
            .addField("text", String::class.java)

        schema.create("Question")
            .addField("id", Long::class.java)
            .addField("text", String::class.java)
            .addRealmListField("answers", schema.get("Answer")!!)
    }

    override fun hashCode(): Int {
        return 37
    }

    override fun equals(o: Any?): Boolean {
        return o is MyMigration
    }
}