"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var User = /** @class */ (function () {
    function User() {
    }
    Object.defineProperty(User.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (name) {
            this._name = name.toUpperCase();
        },
        enumerable: false,
        configurable: true
    });
    return User;
}());
var user = new User();
user.name = 'Hidran';
console.log(user.name);
