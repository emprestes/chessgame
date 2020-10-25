import BoardPosition from "../../../../../main/javascript/chessgame/domain/model/board-position";

describe("A suite is just a function", () => {
    var a;

    it("and so is a spec", () => {
        const positions = BoardPosition;
        a = true;

        console.log(positions);
        expect(a).toBe(true);
    });
});
