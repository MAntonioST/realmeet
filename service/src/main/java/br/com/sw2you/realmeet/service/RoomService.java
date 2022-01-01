package br.com.sw2you.realmeet.service;

import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.domain.model.RoomDTO;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class RoomService {

    private final RoomRepository roomRepoistory;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepoistory, RoomMapper roomMapper) {
        this.roomRepoistory = roomRepoistory;
        this.roomMapper = roomMapper;
    }

    public RoomDTO getRoom(Long id){
        requireNonNull(id);
        Room room = roomRepoistory.findById(id).orElseThrow(RoomNotFoundException::new);
        return  roomMapper.fromEntityToDto(room);
    }

}
