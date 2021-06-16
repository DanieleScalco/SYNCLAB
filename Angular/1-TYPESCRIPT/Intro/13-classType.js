"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var MyLogger = /** @class */ (function () {
    function MyLogger() {
    }
    MyLogger.prototype.log = function (msg) {
        console.log(msg);
    };
    MyLogger.prototype.generateId = function () {
        return Math.round(Math.random() * 10000000);
    };
    return MyLogger;
}());
var MyMailLogger = /** @class */ (function () {
    function MyMailLogger() {
    }
    // Componente di MyLog presa da MyLogger
    MyMailLogger.prototype.log = function () {
    };
    MyMailLogger.prototype.generateId = function () {
        return 1;
    };
    return MyMailLogger;
}());
// Le classi sono dei tipi
var mailLog;
function logData(logger) {
    return logger.generateId();
}
mailLog = new MyMailLogger();
console.log(logData(mailLog));
