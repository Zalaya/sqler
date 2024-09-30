import { ComponentProps } from "react";
import { Meta, StoryObj } from "@storybook/react";
import { NavBar } from "../components/NavBar.tsx";

type StoryProps = ComponentProps<typeof NavBar>;

const meta: Meta<StoryProps> = {
    title: "NavBar",
    component: NavBar
};

export default meta;

type Story = StoryObj<StoryProps>;

export const Default: Story = {
    args: {

    }
};