package com.axelor.gst.service.impl;


import com.axelor.gst.db.Sequence;
import com.axelor.gst.db.repo.SequenceRepository;
import com.axelor.gst.service.SequenceService;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class SequenceServiceImpl implements SequenceService {

    @Inject
    private SequenceRepository repository;

	@Override
	@Transactional
	public String getReference(String name) {
		Sequence sequence = repository.findByModelName(name).fetchOne();
		if(sequence==null) return "";
		
		String nextNumber=sequence.getNextNumber();
		String prefix=sequence.getPrefix();
		String suffix=sequence.getSuffix();
		int padding=sequence.getPadding();
		
		String num=nextNumber.substring(prefix.length(),prefix.length()+padding);
		int numToInt=Integer.parseInt(num)+1;
		String intTostr=Integer.toString(numToInt);
		padding-=intTostr.length();
		for (int i = 0; i < padding; i++) {
			prefix+="0";
		}
		if(suffix!=null)
			prefix=prefix+intTostr+suffix;
		else
			prefix+=intTostr;
		sequence.setNextNumber(prefix);
		repository.save(sequence);
		return prefix;
	}
}
