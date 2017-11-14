package com.roverandfriends.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.roverandfriends.model.Friends;
import com.roverandfriends.model.User;
import com.sun.istack.internal.logging.Logger;

@Service
public class FriendsListService {

	final static Logger logger = Logger.getLogger(FriendsListService.class);

	private static List<Friends> friendslist = new ArrayList<Friends>();
	private static int friendsCount = 3;

	static {
		friendslist.add(new Friends(1, "Jorge Benavides", "User4"));
		friendslist.add(new Friends(2, "Jorge Benavides", "User5"));
		friendslist.add(new Friends(3, "Jorge Benavides", "User6"));
		logger.info("show freidns events after static" + friendslist);
	}

	public List<Friends> retrieveFriendsList(String user) {
		List<Friends> filteredFriendslist = new ArrayList<Friends>();
		for (Friends friend : friendslist) {
			if (friend.getUser().equals(user))
				filteredFriendslist.add(friend);
		}
		logger.info("show friends events after static match jorge " + friendslist);
		return filteredFriendslist;
	}

	public String getCurrentUserName(User user) {
		return user.getUserName();
	}

	public Friends retrieveFriends(int id) {
		for (Friends friends : friendslist) {
			if (friends.getId() == id)
				return friends;
		}
		return null;
	}

	public void updateFriends(Friends friends) {
		friendslist.remove(friends);
		friendslist.add(friends);
	}

	public void addFriends(String name, String userName) {
		friendslist.add(new Friends(++friendsCount, name, userName));
	}

	public void deleteFriends(int id) {
		Iterator<Friends> iterator = friendslist.iterator();
		while (iterator.hasNext()) {
			Friends friends = iterator.next();
			if (friends.getId() == id) {
				iterator.remove();
			}
		}
	}

	public void printFriendsListWithIterator() {
		Iterator name = friendslist.iterator();
		while (name.hasNext()) {
			System.out.println("iterator list " + name.next());
		}
	}
}