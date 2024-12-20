package bank.regional.app.card;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
	@Autowired
	private CardRepository cardRepository;
	
	public Card addCard(Card card) {
		return cardRepository.save(card);
	}
	
	public Optional<Card> getCard(int id) {
		return cardRepository.findById(id);
	}
	
	public List<Card> getCards() {
		return (List<Card>) cardRepository.findAll();
	}
	
	public void deleteCard(int id) {
		cardRepository.deleteById(id);
	}
}
