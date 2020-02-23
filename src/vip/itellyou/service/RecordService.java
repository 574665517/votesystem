package vip.itellyou.service;

import java.util.List;

import vip.itellyou.pojo.Record;

public interface RecordService {
	public void vote(List<Record> records) throws Exception;
}
