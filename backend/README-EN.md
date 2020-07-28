# Make magic - Backend challenge

Hey! Thanks to applying for this position, we hope you can learn something new.

The main purpose of this challenge is to see how you work and how you solve problems.

So, let’s start.


## Introduction

The challenge here is to create a REST API that fulfils some requirements.

We made a partnership with this [website](https://www.potterapi.com) (of course the partnership is only to be more friendly in text) it provides us a lot of information about the Harry Potter series.

We propose you create a CRUD application for harry potter characters, in our opinion an amazing film.

Your application must be able to:
* Create a new character
* Read a single character or all characters
* Update a single character
* Delete a single character

But, to save the correct house which the character belongs to, that can be achieve by integrating with the potter api mentioned earlier


## So, what do we expect?

Let’s start with a simple json with character properties:

```
{
    "name": "Harry Potter",
    "role": "student",
    "school": "Hogwarts School of Witchcraft and Wizardry",
    "house": "5a05e2b252f721a3cf2ea33f",
    "patronus": "stag"
}
```
We want to create a new record with all this information and your application must be able to read, update and delete this record.

NOTES:
* You can specify all required keys
* You can specify all type key values
* The `house` key, or another key with the same meaning, when specified, need to be a `string` with the potterapi house `id`, you can see all documentation in this [link](https://www.potterapi.com/)
* When the house id is invalid you need to return an error message.


## Persistence

This is not required to complete the challenge, but keep in mind, we want to know how do you your work, so this is a greate opportunity to show all of your skills, be free to implement a database persistence if you feel it is important to.


## Filters

The filter helps to get only the data you want…

So, implement a filter by house, like the example above

`http://localhost:3000/api/characters?house=5a05e2b252f721a3cf2ea33f`

The result need to be all characters belongs to the house with id: `5a05e2b252f721a3cf2ea33f`


## Tests

Create all necessary tests
* Unit test
* Integration test

And others you find necessary


## Language

Feel free to use the language you most are comfortable with.


## Tips

As we talked about earlier, this challenge is your time to show your hard skills, so some tips you can use in your project.
It does not define your level but is a great time to impress us, so think about

* Docker
* Documentation
  * Document your code
  * Document your API REST
* Application running
* Code quality
* Circuit-breacker
* Cache
* Retry when some HTTP request fail

Be creative

You need to create a public repository on github or others.

Good luck
