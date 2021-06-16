"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
var Lesson = /** @class */ (function () {
    function Lesson(type, length, title, description) {
        this.type = type;
        this.length = length;
        this.title = title;
        this.description = description;
    }
    Lesson.prototype.getDescription = function () {
        return this.description;
    };
    return Lesson;
}());
var VideoLesson = /** @class */ (function (_super) {
    __extends(VideoLesson, _super);
    function VideoLesson() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    // this.title non è visibile poichè nella superclasse è privato
    // ha description come attributo poichè è sottoclasse di Lesson
    VideoLesson.prototype.setDescription = function (description) {
        this.description = description;
    };
    return VideoLesson;
}(Lesson));
var lesson = new Lesson('VideoCourse', 4, 'Intro', '');
console.log(lesson.getDescription);
