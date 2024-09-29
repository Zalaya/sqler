import { useEffect, useState } from "react";

type UseDebounceProps<T> = {
    value: T;
    delay?: number;
}

/**
 * The function delays the update of the value until after the specified delay.
 * @param value - The value to debounce.
 * @param delay - The delay in milliseconds (optional, default is 300ms).
 * @returns The debounced value.
 */
export const useDebounce = <T>({ value, delay = 300 }: UseDebounceProps<T>): T => {

    const [debouncedValue, setDebouncedValue] = useState<T>(value);

    useEffect(() => {
        const handler = setTimeout(() => {
            setDebouncedValue(value)
        }, delay);

        return () => clearTimeout(handler);
    }, [ value, delay ])

    return debouncedValue;

}