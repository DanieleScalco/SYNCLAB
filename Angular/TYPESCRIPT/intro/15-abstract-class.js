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
// Differenza abstract/interface, le interface non possono avere implementazioni
// Le classi astratte possono avere metodi implementati
// Ha almeno un metodo astratto
// Non si possono instanziare classi astratte
var Logger = /** @class */ (function () {
    function Logger() {
    }
    // Una classe astratta può avere metodi concreti implementati
    Logger.prototype.genereteId = function () {
        return Math.round(Math.random() * 10000000);
    };
    return Logger;
}());
var ConsoleLogger = /** @class */ (function (_super) {
    __extends(ConsoleLogger, _super);
    function ConsoleLogger() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ConsoleLogger.prototype.getMessage = function () {
        throw new Error("Method not implemented.");
    };
    // Override metodo astratto
    ConsoleLogger.prototype.log = function (msg) {
        console.log(msg);
    };
    return ConsoleLogger;
}(Logger));
var CLog = new ConsoleLogger();
CLog.log('Logging to console');
console.log(CLog.genereteId());
