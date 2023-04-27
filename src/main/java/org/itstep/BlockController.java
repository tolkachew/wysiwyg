package org.itstep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BlockController {

    @Autowired
    private BlockService blockService;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("block", new Block());
        model.addAttribute("blocks", blockService.findAll());
        return "index";
    }

    @PostMapping(value = "/save")
    public String save(Block Block, Model model, HttpServletResponse response) {
        //Передать id в заголовке ответа
        Block newBlock =blockService.save(Block);
        long id = newBlock.getId();
        response.addHeader("id", String.valueOf(id));
        model.addAttribute("blocks", blockService.findAll());
        return "redirect:/";
    }
}