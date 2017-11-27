package friends;

public class Person {
	String name;		// the person's name
	Friend firstFriend; // the first friend in the list of this
					    // person's friends
	Person nextPerson;  // the next person in the list of people
	
	public Person(String name, Person nextPerson)
	{
		this.name = name;
		this.nextPerson = nextPerson;
	}

	// A string representing the list of friends of this person.  
	// O(number of friends in the list)
	public String friendString()
	{
		String friends = "";
		Friend next = firstFriend;
		while(next != null)
		{
			friends += next.who.name + " ";
			next = next.nextFriend;
		}

		if (friends.length() >0)
			return friends.substring(0,friends.length() - 1);

		return ""; // replace this line
	
	}
	
	// add friend as a friend of this person
	// O(1)
	public void addFriend(Person friend)
	{
		if(firstFriend == null)
		{
			firstFriend = new Friend(friend, null);
		}
		else
		{
			firstFriend = new Friend(friend, firstFriend);
		}
	}
	
	// remove Person friend as a friend of this person
	// if friend is not a friend of this person, does nothing
	// O(number of friends of this person)
	public void removeFriend(Person friend)
	{

		if (!friend.name.equals(firstFriend.who.name) && firstFriend.nextFriend == null)
			return;
		//------

		if (friend.name.equals(firstFriend.who.name) && firstFriend.nextFriend == null)
		{
			firstFriend = null;
			return;
		}
		//------

		if (friend.name.equals(firstFriend.who.name) && firstFriend.nextFriend != null)
		{
			firstFriend = firstFriend.nextFriend;
			return;
		}
		//------
		Friend searcher = firstFriend;
		while (searcher.nextFriend != null)
		{
			if (searcher.nextFriend.who.name.equals(friend.name))
			{
				if (searcher.nextFriend.nextFriend != null)
				{
					searcher.nextFriend = searcher.nextFriend.nextFriend;
					return;
				}//Try with this else and try w/o it. I think it would still work because if NULL it would point to NULL which is the nextFriend.nextFriend
				else
				{
					searcher.nextFriend = null;
					return;
				}
			}
			searcher = searcher.nextFriend;
		}
		return; // replace this line
	}


/*
Linhs code
		if(friend == null)
			return;

		if (this.firstFriend == null)
			return;

		String ffname = this.firstFriend.who.name;

		if(this.firstFriend.nextFriend == null)
		{
			if (ffname.equals(friend.name))
			{
				this.firstFriend = null;
				return;
			}
		}

		Friend prev = null;

		for(Friend f = this.firstFriend;f!=null;f=f.nextFriend)
		{
			String fname = f.who.name;

			if (fname.equals(friend.name))
			{
				if (prev == null)
				{
					prev = f.nextFriend;
					this.firstFriend = prev;
					return;
				}
				else if (f.nextFriend == null)
				{
					prev.nextFriend = null;
					return;
				}
				else
				{
					prev.nextFriend = f.nextFriend;
					return;
				}
			}
			prev = f;
		}
		return;
	}
*/
}
