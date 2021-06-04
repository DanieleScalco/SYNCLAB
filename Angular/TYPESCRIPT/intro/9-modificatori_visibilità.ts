export {};

class Lesson {

// Di default le proprietà e i metodi sono public
// protected: posso accedere alla prorpietà solo dall'interno
//			  dell'oggetto o da sottoclassi
// private: variabile vista solo all'interno della classe

	type: string
	public length: number
	private title: string
	protected description?: string

	constructor(type: string, length: number, title: string, description?: string) {
		this.type = type;
		this.length = length;
		this.title = title;
		this.description = description;		
	}

	getDescription() {
		return this.description;
	}
}

class VideoLesson extends Lesson {

	// this.title non è visibile poichè nella superclasse è privato
	
	setDescription(description: string) {
		this.description = description;
	}
}

let lesson = new Lesson('VideoCourse', 4, 'Intro', '');

console.log(lesson.getDescription);