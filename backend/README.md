# Backend challenge 

Hey! Thanks to applying for this position, we hope you can learn something new.

What would we like to see in this challenge?

How you work! It’s the main proposal we apply challenges for all applicants

So, let’s start.

## Introduction

This challenge is based on you creating a REST API to complete some requirements.

We made a partnership with this [website](https://www.potterapi.com) (of course the partnership is only to be more friendly in text) it provides for us a lot of information about harry potter.

We propose you create a CRUD application for harry potter characters, in our opinion an amazing film.

Your application must be able to:
* Create new character
* Read a single character or all characters
* Update a single character
* Delete a single character

But, to complete the full challenge, when you create a new character, we would like to save the correct house of character and for that, you can integrate your application with potter api.

## So, what do we expect?

Let’s start with a simple json with character properties:

```
{
 	“name”: “Harry Potter”,
	"role": "student",
	"school": "Hogwarts School of Witchcraft and Wizardry",
    "house": "5a05e2b252f721a3cf2ea33f",
    "patronus": "stag",
}
```
We want to create a new record with all this information.

NOTES:
* You can specify all required keys
* You can specify all type key values
* The “house” key, when specified, need to be a string with the potterapi house id, you can see all documentation in this link https://www.potterapi.com/
* When the house id is invalid you need to return an error message.


## Persistence

It’s not required to complete the challenge, but be in your mind, we want to know how your work, so it is your time to show all your hard skills, be free to implement a database persistence if you feel it is important to.

## Filters

The filter helps to get only the data you want…
So, implement a filter by house, like the example above

`http://localhost:8090/api/characters?house=5a05e2b252f721a3cf2ea33f`

The result need to be all characters has the house id equal 5a05e2b252f721a3cf2ea33f


## Unit tests

Create all the tests you find necessary
Unit test
Integration test

## Language

Fill free to use tha language you are confortable


# Tips

As we talked about earlier, this challenge is your time to show your hard skills, so some tips you can use in your project.
It does not define your level but is a great time to impress us, so think about

* Docker
* Documentation
  * Code
  * REST
* Application running
* Code doccumented

Be creative

Good louck
