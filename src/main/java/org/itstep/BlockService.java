package org.itstep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {
    @Autowired
    private BlockRepo blockRepo;

    public List<Block> findAll() {
        return blockRepo.findAll();
    }

    public Block save(Block block) {
        return
                blockRepo.save(block);
    }

    public Block findById(Long id) {
        return blockRepo.findById(id).get();
    }

    public void deleteById(Long id) {
        blockRepo.deleteById(id);
    }
}