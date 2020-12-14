package listener;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import events.EventContainer;
import logic.Action;
import logic.Article;
import logic.EventBusManager;

public class Editor implements EventListener {
	private static int noReaders;
	private ArrayList<Article> articles = new ArrayList<Article>();

	public Editor() {
	}

	@Subscribe
	public void listen(EventContainer handler) {
		if (handler.getEventType().equals(Action.READ)) {
			noReaders++;
			System.out.println("The number of readers has increased " + noReaders);
		}
	}

	public Article createArticle() {
		System.out.println("Hello. So you want to create an article");

		System.out.println("Insert a title");
		Scanner scanner = new Scanner(System.in);
		String title = scanner.nextLine();

		System.out.println("Insert a domain");
		String domain = scanner.nextLine();

		Article article = new Article(this, title, domain);
		articles.add(article);

		EventBus eventBus = EventBusManager.getInstance();
		eventBus.post(new EventContainer(Action.CREATE, domain, title));

		return article;
	}

	public void modifyArticle(String title) {
		System.out.println("Hello. Here is the data about the article you want to modify: ");

		Article article = null;

		for (Article a : articles) {
			if (a.getTitle().equals(title)) {
				article = a;
			}
		}

		if (article != null) {
			System.out.println("title --- " + article.getTitle() + " --- ");

			while (true) {
				System.out.println("What do you want to modify? (Press: T - title, C - close)");

				Scanner whatToModify = new Scanner(System.in);
				String what = whatToModify.nextLine();
				if (what.equals("T")) {
					System.out.println("Write new title");
					String titleToBeModified = whatToModify.nextLine();
					article.setTitle(titleToBeModified);
					System.out.println("Title modified!!! -- " + article.getTitle());
				} else if (what.contentEquals("C")) {
					whatToModify.close();
					EventBus eventBus = EventBusManager.getInstance();
					eventBus.post(new EventContainer(Action.MODIFY, article.getDomain(), article.getTitle()));
					break;
				}
			}
		} else {
			System.out.println("This article was not found in your list of articles");
		}
	}

	public void deleteArticle(String title) {
		Optional<Article> a = articles.stream().filter(article -> article.getTitle().equals(title)).findFirst();

		if (a.isPresent()) {
			EventBus eventBus = EventBusManager.getInstance();
			eventBus.post(new EventContainer(Action.DELETE, a.get().getDomain(), title));
			articles.remove(a.get());
		} else {
			System.out.println("This article was not found in your list of articles");
		}

	}
}
