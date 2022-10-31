package com.fas10ver.business.abstracts;

import java.util.List;

import com.fas10ver.entities.Textile;
import com.fas10ver.entities.dtos.textileDto.TextileDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;

public interface TextileService {

	public ApiResponse<List<Textile>> getAll();
	public ApiResponse<Textile> getOneTextile(int textileId); 
	public ApiResponse<Textile> add(TextileDtoForCreate textileDtoForCreate);
	public ApiResponse<Textile> update(TextileDtoForCreate textileDtoForUpdate, int TextileId);
}
