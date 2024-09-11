package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		MemberExporter memberExporter = new MemberExporterImpl();
		return memberExporter;
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		MemberImporter memberImporter = new MemberImporterImpl();
		return memberImporter;
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {
			
		Set<Member> memberSet = new LinkedHashSet<>();
		for(Member m : membersFromFile) {
			memberSet.add(m);
		}
		List<Member> nonDuplicateList = new ArrayList<>(memberSet);
		return nonDuplicateList;
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		Map<String,List<Member>> map = new HashMap<>();
		
		for(Member m : validMembers) {
			
			if(!map.containsKey(m.getState())) {
				List<Member> list = new ArrayList<>();
				list.add(m);
				map.put(m.getState(), list);
			}else {
				map.get(m.getState()).add(m);
			}
			
		}
		return map;
	}

	public static void main( String[] args ) {
		
		Main main = new Main();
		File inputFile = new File("Members.txt");
		
		try {
			main.convert(inputFile,"./" , "outputFile.csv"); // calling the convert method
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
