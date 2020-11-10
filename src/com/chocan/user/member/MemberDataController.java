package com.chocan.user.member;

import com.chocan.user.member.Member;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class MemberDataController {

	public void addNewMember(int memberNumber, String memberName, String memberStreetAddress, String memberCity,
			String memberState, String memberZip) {
		// create a new member using the Member class
		Member member = new Member(memberNumber, true, memberName, memberStreetAddress, memberCity, memberState, memberZip);
		
		// save that member to the JSON file
		convertMemberToJSON(member);
	}
	
	private void convertMemberToJSON(Member member) {
        ObjectMapper mapper = new ObjectMapper();
        try {
        	File file = new File("members.json");
        	FileWriter fr = new FileWriter(file, true);
        	fr.append('\n');
            mapper.writeValue(fr, member);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(member);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
