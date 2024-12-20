package bank.regional.app.card;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CardController {
	@Autowired
	private CardService cardService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/card")
	public Card addCard(@RequestBody Card card) {
		return cardService.addCard(card);
	}
	
	@RequestMapping("/card/{id}")
	public Optional<Card> getCard(@PathVariable int id) {
		return cardService.getCard(id);
	}
	
	@RequestMapping("/cards")
	public List<Card> getCards() {
		return cardService.getCards();
	}
	
	@RequestMapping("card/{id}/delete")
	public void deleteCard(@PathVariable int id) {
		cardService.deleteCard(id);
	}
}
