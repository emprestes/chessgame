import Optional from 'optional-js'
import BoardPosition from "./board-position";

const board = {...BoardPosition};

const collect = (position, availablePositions = [], updatePosition) => {
    Optional.of(position)
        .map(updatePosition)
        .filter(newPosition => newPosition !== position)
        .filter(newPosition => board[newPosition])
        .filter(newPosition => availablePositions.push(newPosition) > 0)
        .ifPresent(newPosition => collect(newPosition, availablePositions, updatePosition));
};

const getAvailablePositions = () => [];

export {getAvailablePositions};