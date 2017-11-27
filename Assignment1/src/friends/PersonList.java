package friends;

// represents a list of people as a linked list of Person objects
public class PersonList {
	Person firstPerson;		// First Person object in the list

	public PersonList( )
	{
		this.firstPerson = null;
	}
	
	// finds Person object in this list with given name
	// if none exists, returns null.  Runs in O(number of persons in this list) 
	public Person lookup(String name){

		if(firstPerson == null)
			return null;

		Person searcher = firstPerson;

		/*while (searcher.nextPerson != null)
		{
			if(searcher.nextPerson.name.equals(name))
				return searcher.nextPerson;

			searcher = searcher.nextPerson;
		}*/

		while (searcher != null)
		{
			if(searcher.name.equals(name))
				return searcher;

			searcher = searcher.nextPerson;
		}
		return null; // replace this line
	
	}
	
	// creates a new Person object with name and adds it to the list of 
	// Person objects.  Runs in O(1)
	public Person addPerson(String name)
	{
		if(firstPerson == null)
			return firstPerson = new Person(name, null);


		return firstPerson = new Person(name, firstPerson);
//		return null; // replace this line

	}

}
