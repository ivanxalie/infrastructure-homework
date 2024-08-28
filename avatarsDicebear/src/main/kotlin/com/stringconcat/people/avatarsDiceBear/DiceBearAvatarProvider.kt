package com.stringconcat.people.avatarsDiceBear

import com.stringconcat.people.businessPeople.AvatarProvider
import com.stringconcat.people.businessPeople.Person
import javax.inject.Named

@Named
class DiceBearAvatarProvider : AvatarProvider {
    @Suppress(" UnexpectedIndentation")
    override fun createForPerson(person: Person): String {
        val uniqueValue = person.firstName + person.secondName
        val sex = if (person.sex == Person.Sex.MAN) "male" else "female"
        return "https://avatars.dicebear.com/v2/$sex/$uniqueValue.svg"
    }
}
