package br.com.sw2you.realmeet.controller;

import br.com.sw2you.realmeet.domain.model.RoomDTO;
import br.com.sw2you.realmeet.facade.RoomsApi;
import br.com.sw2you.realmeet.service.RoomService;
import br.com.sw2you.realmeet.util.ResponseEntityUtilis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
public class RoomController implements RoomsApi{

    private final Executor controllersExecutor;
    private final RoomService roomService;

    public RoomController(Executor controllersExecutor, RoomService roomService) {
        this.controllersExecutor = controllersExecutor;
        this.roomService = roomService;
    }

    @Override
    public CompletableFuture<ResponseEntity<RoomDTO>> getRoom(Long id){
        return supplyAsync(() -> roomService.getRoom(id), controllersExecutor).thenApply(ResponseEntityUtilis::ok);
    }

}
