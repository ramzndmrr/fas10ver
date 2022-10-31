package com.fas10ver.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas10ver.business.abstracts.TextileService;
import com.fas10ver.dataAccess.TextileDao;
import com.fas10ver.entities.Textile;
import com.fas10ver.entities.dtos.textileDto.TextileDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;

@Service
public class TextileManager implements TextileService {
	
	private TextileDao textileDao;
	private ModelMapper mapper;

	@Autowired
	public TextileManager(TextileDao textileDao, ModelMapper mapper) {
		this.textileDao = textileDao;
		this.mapper = mapper;
	}
	
	
	@Override
	public ApiResponse<List<Textile>> getAll() {
		List<Textile> list = textileDao.findAll();
		return ApiResponse.default_OK(list);
	}

	@Override
	public ApiResponse<Textile> getOneTextile(int textileId) {
		Textile textile = textileDao.findById(textileId).orElseThrow();
		return ApiResponse.default_OK(textile);
	}
	
	@Override
	public ApiResponse<Textile> add(TextileDtoForCreate textileDtoForCreate) {
		Textile textile = mapper.map(textileDtoForCreate, Textile.class);
		textileDao.save(textile);
		return ApiResponse.default_CREATED(textile);
	}

	@Override
	public ApiResponse<Textile> update(TextileDtoForCreate textileDtoForUpdate, int TextileId) {
		// TODO Auto-generated method stub
		return null;
	}

}
