package friendlist.friendlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import friendlist.friendlist.domain.Friend;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendController {


    private List<Friend> friends = new ArrayList<>();

    @GetMapping("/index")
    public String indexPage(@RequestParam(name = "friend", required = false) String friendName, Model model) {
        if (friendName != null && !friendName.isEmpty()) {
            // Add a new friend to the list
            friends.add(new Friend(friendName, ""));
        }

        // Add the list of friends to the model
        model.addAttribute("friends", friends);

        return "index";

    }
}
