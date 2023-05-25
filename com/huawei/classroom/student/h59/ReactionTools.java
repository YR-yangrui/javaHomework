package com.huawei.classroom.student.h59;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReactionTools {

	String[] readFromFile(String filename) throws Exception{
		FileReader fileReader = new FileReader(filename);
		BufferedReader reader = new BufferedReader(fileReader);
		List<String> reactions = new ArrayList<>();
		String s = reader.readLine();
		while(s != null) {
			if(!s.startsWith("#")) {
				reactions.add(s);
			}
			s = reader.readLine();
		}
		return reactions.toArray(new String[reactions.size()]);
	}

	boolean check(List<String> reacts, Set<String> products) {
		for (String s: reacts) {
			if(!products.contains(s)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 根据reactionFile给出的一系列反应， 判断一个体系中根据init物质，判断出最后可能都存在什么物质
	 * @param reactionFile 体系中初始反应物
	 * @param initComponents 体系中初始反应物
	 * @return 最后体系中存在的全部物质
	 */

	public Set<String> findAllComponents(String reactionFile,Set<String> initComponents){
		Set<String> finalProducts = new HashSet<>(initComponents);
		List<Reaction> reactions = new ArrayList<>();
		try {
			String[] reacts = readFromFile(reactionFile);
			for (String reaction : reacts) {
				String[] rp = reaction.split("=");
				Reaction r = new Reaction(new ArrayList<>(), new ArrayList<>());
				for (String s : rp[0].split(" \\+ ")) {
					s = s.trim();
					r.getReactants().add(s);
				}
				for (String s : rp[1].split(" \\+ ")) {
					s = s.trim();
					r.getProducts().add(s);
				}
				reactions.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int size = 0;
		while(size != finalProducts.size()) {
			size = finalProducts.size();
			for (Reaction reaction : reactions) {
				if(check(reaction.getReactants(), finalProducts)) {
					finalProducts.addAll(reaction.getProducts());
				}
				if(check(reaction.getProducts(), finalProducts)) {
					finalProducts.addAll(reaction.getReactants());
				}
			}
		}
		return finalProducts;
	}
}

